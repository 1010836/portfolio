celery --broker redis://kubernetes.docker.internal:6379/0 inspect active_queues
celery --broker redis://kubernetes.docker.internal:6379/0 inspect clock report

celery --broker redis://kubernetes.docker.internal:6379/0 inspect report --json > report.json
celery --broker redis://kubernetes.docker.internal:6379/0 inspect active_queues --json

celery --broker redis://kubernetes.docker.internal:6379/0 inspect report --json | findstr /I "tz\" \"utc_offset"


