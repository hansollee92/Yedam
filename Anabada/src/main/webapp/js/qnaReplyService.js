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
  },

  // 삭제
  removeReply(qnaReplyNo, successCallback, errorCallback){
    fetch('qnaReplyRemove.do?qnaReplyNo=' + qnaReplyNo)
      .then(resolve => resolve.json())
      .then(successCallback)
      .catch(errorCallback)
  },

  // 등록
	registerReply(param={qnaNo, qnaReplyContent, memberNo}, successCallback, errorCallback){
		fetch('qnaReplyAdd.do?qnaNo='+param.qnaNo+'&qnaReplyContent='+param.qnaReplyContent+'&memberNo='+param.memberNo)
			.then(resolve => resolve.json())
			.then(successCallback)
			.catch(errorCallback)
	},

}