let inputs = require("fs")
  .readFileSync("boj_9935_문자열 폭발.txt")
  .toString()
  .trim()
  .split("\n");
function solution(input) {
  let str = input[0];
  let match = input[1];
  let stack = [];
  let last = match[match.length - 1];
  for (var i = 0; i < str.length; i++) {
    if (str[i] !== last) {
      stack.push(str[i]);
    } else {
      if (stack.length < match.length - 1) {
        stack.push(str[i]);
        continue;
      }
      let idx = stack.length - 1;
      let isSame = true;

      for (var k = match.length - 2; k >= 0; k--) {
        if (stack[idx] !== match[k]) {
          isSame = false;
          break;
        } else {
          idx--;
        }
      }

      if (isSame) {
        for (var j = 0; j < match.length - 1; j++) {
          stack.pop();
        }
      } else {
        stack.push(str[i]);
      }
    }
  }
  if (stack.length === 0) {
    return console.log("FRULA");
  } else {
    console.log(stack.join(""));
  }
}
solution(inputs);
