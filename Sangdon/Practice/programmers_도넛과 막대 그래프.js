function solution(edges) {
  var answer = new Array(4).fill(0);
  let graph = {};
  edges.forEach(d => {
    let [a, b] = d;
    if (graph[a] === undefined) {
      graph[a] = Array.from(Array(2), () => Array());
      graph[a][0].push(b);
      if (graph[b] === undefined) {
        graph[b] = Array.from(Array(2), () => Array());
        graph[b][1].push(a);
      } else {
        graph[b][1].push(a);
      }
    } else {
      graph[a][0].push(b);
      if (graph[b] === undefined) {
        graph[b] = Array.from(Array(2), () => Array());
        graph[b][1].push(a);
      } else {
        graph[b][1].push(a);
      }
    }
  });
  let entries = Object.entries(graph);
  for (var i = 0; i < entries.length; i++) {
    if (entries[i][1][0].length >= 2 && entries[i][1][1].length === 0) {
      answer[0] = parseInt(entries[i][0]);
      break;
    }
  }
  let totalNum = graph[answer[0]][0].length;
  for (const key in graph) {
    if (graph[key][0].length === 2 && graph[key][1].length >= 2) {
      answer[3]++;
    } else if (graph[key][0].length === 0 && graph[key][1].length >= 1) {
      answer[2]++;
    }
  }
  answer[1] = totalNum - (answer[3] + answer[2]);
  return answer;
}
