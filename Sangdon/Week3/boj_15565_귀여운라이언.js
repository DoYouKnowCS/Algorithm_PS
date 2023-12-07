let inputs = require("fs")
  .readFileSync("boj_15565_귀여운라이언.txt")
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  let [n, k] = input[0].split(" ").map(d => +d);
  let arr = input[1].split(" ").map(d => +d);
  let oneIdx = [];
  let min = 1000001;
  for (var i = 0; i < arr.length; i++) {
    if (arr[i] === 1) oneIdx.push(i);
  }
  //   console.log(oneIdx);
  for (var j = 0; j <= oneIdx.length - k; j++) {
    min = Math.min(min, oneIdx[j + k - 1] - oneIdx[j]);
  }
  if (min === 1000001) {
    console.log(-1);
  } else {
    console.log(min + 1);
  }
}
solution(inputs);
