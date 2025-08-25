// fetch(fetch(fetch(코드...)))
// fetch
// fetch
// fetch
// async function() { awiat 호출 }

async function getPost() {
  let response = await fetch("http://localhost:3000/posts");
  let data = await response.json();
  //console.log(data);
  data.forEach(async (post) => {
    console.log("post번호" + post.id + "에 대한 comments list");
    let response = await fetch("http://localhost:3000/comments");
    let data = await response.json();
    data.forEach((comment) => {
      if (comment.postId == post.id) {
        console.log(`    내용: ${comment.body}`);
      }
    });
  });
}

getPost(); //함수호출

async function getComment() {
  data.forEach((post) => {});
}

// fetch("http://localhost:3000/posts")
//   .then((response) => response.json())
//   .then((data) => {
//     console.log(data);
//     data.forEach((post) => {
//       console.log("post번호" + post.id + "에 대한 comments list");
//       // post에 대한 comments 조회
//       fetch("http://localhost:3000/comments")
//         .then((response) => response.json())
//         .then((data) => {
//           data.forEach((comment) => {
//             if (comment.postId == post.id) {
//               console.log("     내용: " + comment.body);
//             }
//           });
//         })
//         .catch(console.log);
//       //end of comments fetch
//     });
//   })
//   .catch(console.log);
