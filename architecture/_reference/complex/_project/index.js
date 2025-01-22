//#region 1. no abstraction
function f1() {
    return 2 + 2;
}
const r1 = f1();
console.log(r1);
//#endregion

//#region 1. data abstraction

//#region   1.1 why:            to create useful programs
//   1. a program that can be used in multiple UC (contexts)
//   2. the same code can be used in different contexts (reuse)
//   3. advantages
//     1. less code to maintain/create
//     2. code correction/improve in only one place
//        1. will solve/improve problems everywhere
//#endregion

//#region   1.2 drawback:       increase complexity
//                    operate unknown data
//#endregion

// 5. solution:       type checking
// 6. drawback:       increase verbose
//#endregion


function f2(a, b) {
    return a + b;
}
const r2 = f2(2, 2);
console.log(r2);

//#endregion

//#region 2. operations abstraction
/*
 * 1. why:            to increase the usefulness (reuse)
 */

//#region   2.1 functional programing
function add(a, b) {
    return   a + b;
}
function div(a, b) {
    return a / b;
}
function f3(a, b, c) {
    return a(2,2);
}
const r3 = f3(add, 2, 2);
console.log(r3);


//#region

// 1. can I change this code?
//   1. need to understand all UC where the code is used
//   2. how
//     1. find all references
//     2. forEach( reference)
//       1. understand the sequence (flux/path)
//       2. see use-case 2
//       3. very important: unitary test
//       4. https://www.overops.com/blog/static-vs-dynamic-code-analysis-how-to-choose-between-them/
//       5. https://www.google.com/search?q=Static+vs+dynamic+code+analysis&rlz=1C1GCEA_enPT1015PT1015&sourceid=chrome&ie=UTF-8   
