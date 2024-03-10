let inputs = require("fs")
  .readFileSync("boj_14891_톱니바퀴.txt")
  .toString()
  .trim()
  .split("\n");

const clockLotate = board => {
  let popped = board.pop();
  board.unshift(popped);
  return board;
};

const deClockLotate = board => {
  let shifted = board.shift();
  board.push(shifted);
  return board;
};
function solution(input) {
  let board = [];
  for (var i = 0; i < 4; i++) {
    board.push(input[i].split("").map(d => +d));
  }
  let times = +input[4];
  // 우 idx -> 2, 좌 idx -> 6
  for (var k = 5; k < 5 + times; k++) {
    let [num, dir] = input[k].split(" ").map(d => +d);
    num--;
    switch (num) {
      case 0:
        let check1 = new Array(4).fill(false);
        var i = 0;
        var now = 0;

        while (i < 3 && board[i][2] !== board[i + 1][6]) {
          check1[i] = true;
          check1[i + 1] = true;
          i++;
        }
        console.log(check1);
        while (check1[now]) {
          if (dir === 1) {
            board[now] = clockLotate(board[now]);
            dir = -1;
            now++;
          } else {
            board[now] = deClockLotate(board[now]);
            dir = 1;
            now++;
          }
        }
        break;
      case 3:
        let check2 = new Array(4).fill(false);
        var i = 3;
        var now = 3;
        while (i > 0 && board[i][6] !== board[i - 1][2]) {
          check2[i] = true;
          check2[i - 1] = true;
          i--;
        }
        console.log(check2);
        while (check2[now]) {
          if (dir === 1) {
            board[now] = clockLotate(board[now]);
            dir = -1;
            now--;
          } else {
            board[now] = deClockLotate(board[now]);
            dir = 1;
            now--;
          }
        }
        break;
      default:
        let check3 = new Array(4).fill(false);
        var l = num;
        var r = num;
        var now = num;
        var nowL = num - 1;
        var dL = 1;
        var nowR = num + 1;
        var dR = 1;

        while (l > 0 && board[l][6] !== board[l - 1][2]) {
          check3[l] = true;
          check3[l - 1] = true;
          l--;
        }
        while (r < 3 && board[r][2] !== board[r + 1][6]) {
          check3[r] = true;
          check3[r + 1] = true;
          r++;
        }
        console.log(check3);
        if (check3[now]) {
          if (dir === 1) {
            board[now] = clockLotate(board[now]);
            dR = -1;
            dL = -1;
          } else {
            board[now] = deClockLotate(board[now]);
            dR = 1;
            dL = 1;
          }
        }
        while (nowR < 4 && check3[nowR]) {
          if (dR === 1) {
            board[nowR] = clockLotate(board[nowR]);
            dR = -1;
            nowR++;
          } else {
            board[nowR] = deClockLotate(board[nowR]);
            dR = 1;
            nowR++;
          }
        }
        while (nowL >= 0 && check3[nowL]) {
          if (dL === 1) {
            board[nowL] = clockLotate(board[nowL]);
            dL = -1;
            nowL--;
          } else {
            board[nowL] = deClockLotate(board[nowL]);
            dL = 1;
            nowL--;
          }
        }
        break;
    }
  }
  let sum = 0;
  if (board[0][0] === 1) sum += 1;
  if (board[1][0] === 1) sum += 2;
  if (board[2][0] === 1) sum += 4;
  if (board[3][0] === 1) sum += 8;

  console.log(sum);
}
solution(inputs);
