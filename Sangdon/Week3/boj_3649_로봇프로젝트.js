let inputs = require("fs")
  .readFileSync("boj_3649_로봇프로젝트.txt")
  .toString()
  .trim()
  .split("\n");
function solution(input) {
  let k = 0;
  while (k < input.length) {
    let x = +input[k] * 10000000;
    k++;
    let size = +input[k];
    k++;
    let ansArr = "";
    let arr = [];
    let l = 0;
    for (var i = k; i < k + size; i++) {
      arr.push(+input[i]);
    }
    arr.sort((a, b) => a - b);
    let r = arr.length - 1;
    while (l < r) {
      if (arr[l] + arr[r] === x) {
        ansArr = `yes ${arr[l]} ${arr[r]}`;
        break;
      } else if (arr[l] + arr[r] < x) {
        l++;
      } else {
        r--;
      }
    }
    if (ansArr.length === 0) console.log("danger");
    else console.log(ansArr);
    k += size;
  }
  //   console.log(k);
}
solution(inputs);
