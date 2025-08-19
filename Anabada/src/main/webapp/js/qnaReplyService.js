/**
 * qnaReplyService.js
 */

const svc = {
  
  // 댓글 목록
  replyList(qnaNo, successCallback, errorCallback){
    fetch('qnaReplyList.do?qnaNo=' + qnaNo)
      .then(resolve => resolve.json())
      .then(successCallback)
      .catch(errorCallback)
  }

}