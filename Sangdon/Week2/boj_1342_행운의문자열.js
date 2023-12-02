let inputs = require("fs")
  .readFileSync("boj_1342_행운의문자열.txt")
  .toString()
  .trim()
  .split("\n");
const check = arr => {
  for (var i = 1; i < arr.length - 1; i++) {
    if (arr[i - 1] === arr[i] || arr[i + 1] === arr[i]) {
      return true;
    }
  }
  return false;
};
function solution(input) {
  let arrs = input[0].split("");
  let len = arrs.length;
  let set = new Set();
  let answer = 0;
  let visited = new Array(len).fill(false);
  const back = (arr, result) => {
    if (result.length === len) {
      if (!set.has(result.join(""))) {
        if (!check(result)) answer++;
        set.add(result.join(""));
      }
      //   console.log(result);
      return;
    }
    for (var k = 0; k < len; k++) {
      if (!visited[k]) {
        result.push(arr[k]);
        visited[k] = true;
        back(arr, result);
        result.pop();
        visited[k] = false;
      }
    }
  };
  back(arrs, []);
  console.log(answer);
}
solution(inputs);
