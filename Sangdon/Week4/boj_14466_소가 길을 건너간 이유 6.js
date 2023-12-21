let inputs = require("fs")
  .readFileSync("boj_14466_소가 길을 건너간 이유 6.txt")
  .toString()
  .trim()
  .split("\n");

function solution(input) {
  let [n, k, r] = input[0].split(" ").map(Number);
  let road = Array.from(Array(n + 1), () => Array(n + 1).fill(0));
  console.log(road);
}
solution(inputs);
