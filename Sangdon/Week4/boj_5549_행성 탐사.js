const { createDiffieHellmanGroup } = require("crypto");

let inputs = require("fs")
  .readFileSync("boj_5549_행성 탐사.txt")
  .toString()
  .trim()
  .split("\n");

const makeSum = str => {
  let splited = [0, 0, 0];
  switch (str) {
    case "J":
      //   console.log(1);
      splited[0] = splited[0] + 1;
      break;
    case "O":
      splited[1] = splited[1] + 1;
      break;
    case "I":
      splited[2] = splited[2] + 1;
      break;
  }
  return splited.join(" ");
};

const countSum = (dp, map, x, y, mode, c, d) => {
  let result = [0, 0, 0];
  if (mode === 1) {
    let str1 = dp[x - 1][y - 1].split(" ").map(Number);
    let str2 = dp[x - 1][y].split(" ").map(Number);
    let str3 = dp[x][y - 1].split(" ").map(Number);
    let str4 = makeSum(map[x - 1][y - 1])
      .split(" ")
      .map(Number);
    for (var i = 0; i < 3; i++) {
      result[i] = str3[i] + str2[i] - str1[i] + str4[i];
    }
    return result.join(" ");
  } else {
    let str1 = dp[c][d].split(" ").map(Number);
    let str2 = dp[x - 1][d].split(" ").map(Number);
    let str3 = dp[c][y - 1].split(" ").map(Number);
    let str4 = dp[x - 1][y - 1].split(" ").map(Number);

    for (var i = 0; i < 3; i++) {
      result[i] = str1[i] - str2[i] - str3[i] + str4[i];
    }
    return result.join(" ");
  }
};
function solution(input) {
  let [n, m] = input[0].split(" ").map(Number);
  let map = [];
  let k = +input[1];
  let dp = Array.from(Array(n + 1), () => Array(m + 1).fill("0 0 0"));
  for (var i = 2; i < 2 + n; i++) {
    map.push(input[i].split(""));
  }
  dp[1][1] = makeSum(map[0][0]);
  for (var x = 1; x <= n; x++) {
    for (var y = 1; y <= m; y++) {
      dp[x][y] = countSum(dp, map, x, y, 1);
    }
  }
  for (var j = 2 + n; j < 2 + n + k; j++) {
    let [a, b, c, d] = input[j].split(" ").map(Number);
    let ans = countSum(dp, map, a, b, 2, c, d);
    console.log(ans);
  }
}
solution(inputs);
