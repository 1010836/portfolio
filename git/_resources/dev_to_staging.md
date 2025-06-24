Git will only consider a commit “shared” between two branches when both branches contain **the exact same commit ID (SHA-1)** in their ancestry.
Because **`git cherry-pick` always creates a *new* commit with a new SHA** on the target branch, a cherry-picked change never reduces the *ahead-by* number that Azure DevOps (or GitHub, GitLab, etc.) shows when you compare **dev** with **staging**. That counter is purely a graph calculation: “how many SHAs are reachable from *dev* that are not reachable from *staging*?”.

### What this means for a GitLab-Flow-style environment branch model

| Goal                                                                                                  | Can you do it with cherry-pick?                                     | Why / alternative                                                                                                                  |
| ----------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------- |
| Promote *some* dev commits to **staging** *without* their original SHAs                               | **Yes**, but the ahead/behind metric becomes meaningless            | Cherry-pick is copy-paste: good for hot-fixes, not for measuring what’s left to promote                                            |
| Promote *some* dev commits **and keep their SHAs** so you can still see “dev is ahead by *N* commits” | **Only if those commits form a contiguous block at the tip of dev** | Git can fast-forward or merge a range, but it **cannot** merge commit `C` if commits `A…B` that precede it in history are excluded |

#### Key rule

> **You cannot keep the original SHA of a commit unless you also keep *every* parent commit that comes before it**.

---

## Implementing GitLab Flow in Azure DevOps

GitLab Flow’s *environment-branch* flavour says each long-lived branch represents an environment (dev → staging → production) and code **flows downstream only via merge requests**.
In Azure DevOps you reproduce that like this:

### 1 Create *feature* (or bug-fix) branches off **dev**

All new work—including hot-fixes—starts on a short-lived branch and is merged into **dev** with a pull request (PR). This keeps **dev** green and integration-tested, matching GitLab Flow’s “everything lands in dev first” rule.

### 2 Promote a *range* of commits to **staging**

When QA decides “everything up to commit `X` on dev is good,” you have two cases:

| Case                                                         | How to move it                                                                                                                                                                                                                                                                                                                                              | Result |
| ------------------------------------------------------------ | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------ |
| **`X` is the *tip* of dev** and you want all earlier commits | Open a **PR from dev → staging** and complete it. Azure will fast-forward or create one merge commit containing all SHAs, so **dev’s ahead count goes to 0**.                                                                                                                                                                                               |        |
| `X` is *not* the tip (QA wants a subset)                     | Create a **release / staging-candidate branch**: <br/>`bash<br/>git checkout -b promote/X origin/staging<br/>git merge --no-ff <commit-X> # or rebase --onto<br/>git push -u origin promote/X<br/>`<br/>Open a PR **promote/X → staging**. Only commits up to `X` are included and *their SHAs are preserved* because the merge brings their full ancestry. |        |

> **Why not cherry-pick?**
> Cherry-picking would copy just commit `X`, but its parents (`A…W`) would be missing, so Git must assign a new SHA—breaking the ahead/behind metric you rely on.

### 3 Handle hot-fixes

If a production bug is fixed on **dev** but needs to ship quickly, GitLab Flow recommends *back-porting* by cherry-picking the hot-fix **from dev into staging and production branches**, then later merging staging back down into dev to realign histories.
Because that hot-fix commit *originates* on dev, its SHA will already be on dev; the cherry-pick on staging will get a *new* SHA, but when staging is merged downstream the ancestry reconciles.

---

## FAQ and practical tips

### “Can I tell Azure DevOps to include only selected dev commits in a PR?”

No. Azure PRs compare branch heads only. Selective promotion = create a temporary branch that *contains only those commits* (via `git merge <sha>` or `git rebase --onto`), then PR that branch into staging.

### “How do I see what’s left to test?”

Run:

```bash
git fetch origin
git rev-list --left-right --count origin/staging...origin/dev
```

The **second** number is how many commits are still on dev but not staging.

### “What if commits aren’t contiguous?”

Re-order them with an *interactive rebase* on dev so the QA-approved commits form a clean tip; then merge that tip to staging. Non-contiguous promotion otherwise requires cherry-picking and forgoing the ahead/behind counter.

### “Is there a Microsoft-endorsed version of this?”

Yes: **Release Flow** (used by the Azure DevOps team) works the same way—hot-fixes cherry-picked, releases branch off main, all code flows downstream via PRs.

---

## Take-aways

1. **Ahead/behind counts depend on identical SHAs.**
2. **Cherry-pick ≠ promote**—it duplicates commits and doesn’t change ahead/behind.
3. **To keep counts accurate, promote commits with merge or rebase onto a staging-candidate branch, then PR that branch.**
4. **Use cherry-pick only for true back-ports or hot-fixes.**

Following this pattern in Azure DevOps gives you the GitLab Flow advantages—separate environment branches, traceable history, and a reliable view of what work still needs promoting.
