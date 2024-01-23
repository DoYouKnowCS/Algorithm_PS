let inputs = require("fs")
  .readFileSync("boj_1309_동물원.txt")
  .toString()
  .trim()
  .split("\n");
function solution(input) {
  let n = +input[0];
  let dp = Array(n).fill(0);
  dp[0] = 0;
  dp[1] = 3;
  dp[2] = 7;
  dp[3] = 17;
  for (var i = 4; i <= n; i++) {
    dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9901;
  }
  console.log(dp[n] % 9901);
}
solution(inputs);
