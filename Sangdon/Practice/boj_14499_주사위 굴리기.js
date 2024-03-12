let inputs = require("fs")
  .readFileSync("boj_14499_주사위 굴리기.txt")
  .toString()
  .trim()
  .split("\n");

const lotate = (dice, dir) => {
  let newDice = dice.slice();
  if (dir === 2) {
    let tmp = newDice[0][1];
    for (var i = 0; i < 3; i++) {
      newDice[i][1] = newDice[i + 1][1];
    }
    newDice[3][1] = tmp;
    return newDice;
  } else if (dir === 3) {
    let tmp = newDice[3][1];
    for (var i = 3; i > 0; i--) {
      newDice[i][1] = newDice[i - 1][1];
    }
    newDice[0][1] = tmp;
    return newDice;
  } else if (dir === 0) {
    let tmp = newDice[1].pop();
    newDice[1].unshift(newDice[3][1]);
    newDice[3][1] = tmp;
    return newDice;
  } else {
    let tmp = newDice[1].shift();
    newDice[1].push(newDice[3][1]);
    newDice[3][1] = tmp;
    return newDice;
  }
};

const lotateSide = (dice, dir) => {
  let newDice = dice.slice();
};
function solution(input) {
  let [n, m, x, y, k] = input[0].split(" ").map(d => +d);
  let board = [];
  let dx = [0, 0, -1, 1];
  let dy = [1, -1, 0, 0];
  let dice = Array.from(Array(4), () => Array(3).fill(0));
  for (var i = 1; i < 1 + n; i++) {
    board.push(input[i].split(" ").map(d => +d));
  }
  input[1 + n].split(" ").map(d => {
    let dir = +d;
    dir--;

    let nx = x + dx[dir];
    let ny = y + dy[dir];
    if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
      if (board[nx][ny] === 0) {
        dice = lotate(dice, dir);
        board[nx][ny] = dice[3][1];
      } else {
        dice = lotate(dice, dir);
        dice[3][1] = board[nx][ny];
        board[nx][ny] = 0;
      }
      x = nx;
      y = ny;
      console.log(dice[1][1]);
    }
  });
}
solution(inputs);
