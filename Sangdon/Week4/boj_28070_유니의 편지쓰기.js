let inputs = require("fs")
  .readFileSync("boj_28070_유니의 편지쓰기.txt")
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  let n = +input[0];
  let max = 0;
  let idx = 0;
  let arr = new Array(100000).fill(0);
  let sum = new Array(100000).fill(0);
  sum[0] = arr[0];
  for (var i = 1; i < 1 + n; i++) {
    let [start, end] = input[i].split(" ");
    let [sY, sD] = start.split("-").map(Number);
    let [eY, eD] = end.split("-").map(Number);
    let sI = (sY - 2000) * 12 + sD - 1;
    let eI = (eY - 2000) * 12 + eD - 1;
    arr[sI] += 1;
    arr[eI + 1] -= 1;
  }
  for (var i = 1; i < sum.length; i++) {
    sum[i] = arr[i] + sum[i - 1];
    if (sum[i] > max) {
      max = sum[i];
      idx = i;
    }
  }
  let month = 2000 + Math.floor(idx / 12);
  let day = (idx % 12) + 1;
  if (Math.floor(day / 10) > 0) {
    console.log(`${month}-${day}`);
  } else {
    console.log(`${month}-0${day}`);
  }
}
solution(inputs);
