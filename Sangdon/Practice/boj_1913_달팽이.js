let inputs = require("fs")
  .readFileSync("boj_1913_달팽이.txt")
  .toString()
  .trim()
  .split("\n");
function solution(input) {
  let num = +input[0];
  let find = +input[1];
  let posi = [];
  let [x, y] = [0, 0];
  let end = Math.pow(num, 2);

  let arr = Array.from(Array(num), () => Array(num).fill(0));

  while (num > 0) {
    //하
    for (var i = 0; i < num; i++) {
      if (end === find) {
        posi.push(x + 1, y + 1);
      }
      arr[x++][y] = end--;
    }
    //우
    num--;
    x--;
    y++;
    for (var i = 0; i < num; i++) {
      if (end === find) {
        posi.push(x + 1, y + 1);
      }
      arr[x][y++] = end--;
    }

    //상
    y--;
    x--;
    for (var i = 0; i < num; i++) {
      if (end === find) {
        posi.push(x + 1, y + 1);
      }
      arr[x--][y] = end--;
    }
    //좌
    num--;
    x++;
    y--;
    for (var i = 0; i < num; i++) {
      if (end === find) {
        posi.push(x + 1, y + 1);
      }
      arr[x][y--] = end--;
    }
    x++;
    y++;
  }
  arr.forEach((d, i) => {
    console.log(d.join(" "));
  });
  console.log(posi.join(" "));
}
solution(inputs);
