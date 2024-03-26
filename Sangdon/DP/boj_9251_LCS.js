let inputs = require("fs")
  .readFileSync("boj_9251_LCS.txt")
  .toString()
  .trim()
  .split("\n");
function solution(input) {
  let str1 = input[0];
  let str1Len = str1.length;
  let str2 = input[1];
  let str2Len = str2.length;
  let arr = Array.from(Array(str1Len + 1), () => Array(str2Len + 1).fill(0));
  for (var i = 1; i < arr.length; i++) {
    for (var k = 1; k < arr[0].length; k++) {
      if (str1[i - 1] === str2[k - 1]) {
        arr[i][k] = arr[i - 1][k - 1] + 1;
      } else {
        arr[i][k] = Math.max(arr[i - 1][k], arr[i][k - 1]);
      }
    }
  }
  console.log(arr[str1Len][str2Len]);
}
solution(inputs);
