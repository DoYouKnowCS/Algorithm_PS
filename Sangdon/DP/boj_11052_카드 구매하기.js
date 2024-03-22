let inputs = require("fs")
  .readFileSync("boj_11052_카드 구매하기.txt")
  .toString()
  .trim()
  .split("\n");
function solution(input) {
  let n = +input[0];
  let dp = new Array(n).fill(0);
  dp.unshift(0);
  let card = input[1].split(" ").map(d => +d);
  dp[1] = card[0];
  dp[2] = Math.max(dp[1] * 2, card[1]);
  for (var i = 3; i < n + 1; i++) {
    let max = 0;
    for (var k = 1; k < i; k++) {
      max = Math.max(dp[k] + dp[i - k], max, card[i - 1]);
    }
    dp[i] = max;
  }
  console.log(dp[n]);
}
solution(inputs);
