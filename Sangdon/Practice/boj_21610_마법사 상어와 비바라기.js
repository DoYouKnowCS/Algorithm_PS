let inputs = require("fs")
  .readFileSync("boj_21610_마법사 상어와 비바라기.txt")
  .toString()
  .trim()
  .split("\n");

const checkCross = (map, n, x, y) => {
  //   console.log(x, y);
  let count = 0;
  if (
    x - 1 >= 0 &&
    y - 1 >= 0 &&
    x - 1 < n &&
    y - 1 < n &&
    map[x - 1][y - 1] !== 0
  ) {
    count++;
  }
  if (
    x - 1 >= 0 &&
    y + 1 >= 0 &&
    x - 1 < n &&
    y + 1 < n &&
    map[x - 1][y + 1] !== 0
  ) {
    count++;
  }
  if (
    x + 1 >= 0 &&
    y + 1 >= 0 &&
    x + 1 < n &&
    y + 1 < n &&
    map[x + 1][y + 1] !== 0
  ) {
    count++;
  }
  if (
    x + 1 >= 0 &&
    y - 1 >= 0 &&
    x + 1 < n &&
    y - 1 < n &&
    map[x + 1][y - 1] !== 0
  ) {
    count++;
  }
  return count;
};

const getDirection = (n, dir, count, x, y) => {
  count = count % n;
  switch (dir) {
    case 1:
      y -= count;
      break;
    case 2:
      x -= count;
      y -= count;
      break;
    case 3:
      x -= count;
      break;
    case 4:
      x -= count;
      y += count;
      break;
    case 5:
      y += count;
      break;
    case 6:
      x += count;
      y += count;
      break;
    case 7:
      x += count;
      break;
    case 8:
      x += count;
      y -= count;
      break;
  }
  if (x < 0) {
    x += n;
  } else if (x >= n) {
    x -= n;
  }
  if (y < 0) {
    y += n;
  } else if (y >= n) {
    y -= n;
  }
  return [x, y];
};
function solution(input) {
  let answer = 0;
  let [n, m] = input[0].split(" ").map(d => +d);
  let map = [];
  let cloud = [
    [n - 1, 0],
    [n - 1, 1],
    [n - 2, 0],
    [n - 2, 1],
  ];
  for (var i = 1; i < 1 + n; i++) {
    map.push(input[i].split(" ").map(d => +d));
  }
  for (var k = 1 + n; k < 1 + n + m; k++) {
    let [d, s] = input[k].split(" ").map(d => +d);
    let visited = {};
    let newArr = [];
    cloud.forEach(data => {
      let [x, y] = data;
      let [nX, nY] = getDirection(n, d, s, x, y);
      newArr.push([nX, nY]);
    });
    cloud = newArr;
    cloud.forEach(d => {
      let [a, b] = d;
      map[a][b] += 1;

      visited[`${a},${b}`] = 1;
    });
    cloud.forEach(data2 => {
      let [a, b] = data2;
      let amount = checkCross(map, n, a, b);
      map[a][b] += amount;
    });

    cloud = [];
    for (var q = 0; q < n; q++) {
      for (var w = 0; w < n; w++) {
        if (map[q][w] >= 2 && visited[`${q},${w}`] === undefined) {
          cloud.push([q, w]);
          map[q][w] -= 2;
        }
      }
    }
    // console.log(map);
    // console.log(cloud);
  }
  for (var q = 0; q < n; q++) {
    for (var w = 0; w < n; w++) {
      answer += map[q][w];
    }
  }
  // console.log(map);
  console.log(answer);
}
solution(inputs);
