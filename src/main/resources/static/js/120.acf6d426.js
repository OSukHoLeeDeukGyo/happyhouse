"use strict";(self["webpackChunkvue_board_bootstrap"]=self["webpackChunkvue_board_bootstrap"]||[]).push([[120],{7120:function(t,e,i){i.r(e),i.d(e,{default:function(){return p}});var r=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("b-container",{staticClass:"bv-example-row mt-3"},[i("b-row",{staticClass:"mb-1"},[i("b-col",{staticClass:"text-left"},[i("b-button",{attrs:{variant:"outline-primary"},on:{click:t.listArticle}},[t._v("목록")])],1),i("b-col",{staticClass:"text-right"},[t.isWriter?i("b-button",{staticClass:"mr-2",attrs:{variant:"outline-info",size:"sm"},on:{click:t.moveModifyArticle}},[t._v("글수정")]):t._e(),t.isWriter?i("b-button",{attrs:{variant:"outline-danger",size:"sm"},on:{click:t.deleteArticle}},[t._v("글삭제")]):t._e()],1)],1),i("b-row",{staticClass:"mb-1"},[i("b-col",[i("b-card",{staticClass:"mb-2",attrs:{"header-html":"<h3>"+t.article.articleno+".\n        "+t.article.subject+"</h3><div><h6>작성자 : "+t.article.userid+"</div><div>"+t.article.regtime+"</div><div>조회수 : "+t.article.hit+"</h6></div>","border-variant":"dark","no-body":""}},[i("b-card-body",{staticClass:"text-left"},[i("div",{domProps:{innerHTML:t._s(t.message)}})])],1)],1)],1),i("hr"),!t.isReplied||t.isModifying?i("b-row",{staticClass:"mb-1"},[i("b-col",[this.userInfo?i("b-form",{on:{submit:t.onSubmit}},[i("b-form-group",{attrs:{id:"userid-group",label:"답변 작성자:","label-for":"userid"}},[i("b-form-input",{attrs:{id:"userid",type:"text",required:"",readonly:""},model:{value:t.userInfo.userid,callback:function(e){t.$set(t.userInfo,"userid",e)},expression:"userInfo.userid"}})],1),i("b-form-group",{attrs:{id:"reply-group",label:"답변 내용:","label-for":"reply"}},[i("b-form-textarea",{attrs:{id:"reply",placeholder:"내용 입력...",rows:"3","max-rows":"6"},model:{value:t.article.reply,callback:function(e){t.$set(t.article,"reply",e)},expression:"article.reply"}})],1),i("b-button",{staticClass:"m-1",attrs:{type:"submit",variant:"primary"}},[t._v("답글작성")]),i("b-button",{staticClass:"m-1",attrs:{type:"button",variant:"danger"},on:{click:t.cancleReply}},[t._v("취소")])],1):t._e()],1)],1):t._e(),t.isReplier&&!t.isModifying?i("b-row",{staticClass:"mb-1"},[i("b-col",{staticClass:"text-right"},[i("b-button",{staticClass:"mr-2",attrs:{variant:"outline-info",size:"sm"},on:{click:t.modifyReply}},[t._v("답글수정")]),i("b-button",{attrs:{variant:"outline-danger",size:"sm"},on:{click:t.deleteReply}},[t._v("답글삭제")])],1)],1):t._e(),t.isReplied&&!t.isModifying?i("b-row",{staticClass:"mb-1"},[i("b-col",[i("b-card",{staticClass:"mb-2",attrs:{"header-html":"<div><h6>"+t.article.replier+"님의 답변</div><div>"+t.article.replyregtime+"</h6></div>","border-variant":"dark","no-body":""}},[i("b-card-body",{staticClass:"text-left"},[i("div",{domProps:{innerHTML:t._s(t.replymsg)}})])],1)],1)],1):t._e()],1)},s=[],a=i(803),l=i(4665),n=i(5748);const o="memberStore";var c={name:"QnaDetail",data(){return{article:{},isWriter:!1,isReplied:!1,isReplier:!1,isModifying:!1}},computed:{...(0,l.rn)(o,["userInfo"]),message(){return this.article.content?this.article.content.split("\n").join("<br>"):""},replymsg(){return console.log(this.article.reply),this.article.reply?this.article.reply.split("\n").join("<br>"):""}},created(){(0,a.fq)(this.$route.params.articleno,(t=>{this.article=t.data,n.Z.get(`/qna/hit/${this.article.articleno}`).then((()=>{this.article.reply&&(this.isReplied=!0,this.userInfo&&this.article.replier===this.userInfo.userid&&(this.isReplier=!0)),this.userInfo&&this.userInfo.userid===this.article.userid&&(this.isWriter=!0)}))}),(t=>{console.log("삭제시 에러발생!!",t)}))},methods:{onSubmit(t){t.preventDefault();let e=!0,i="";!this.article.content&&(i="답변 내용을 입력해주세요",e=!1,this.$refs.content.focus()),e?this.submitReply():alert(i)},submitReply(){n.Z.post(`/qna/reply/${this.article.articleno}`,{articleno:this.article.articleno,replier:this.userInfo.userid,reply:this.article.reply}).then((({data:t})=>{let e="댓글 등록 처리시 문제가 발생했습니다.";"success"===t&&(e="댓글 등록이 완료되었습니다."),alert(e),location.reload(!0)}))},listArticle(){this.$router.push({name:"qnaList"})},moveModifyArticle(){this.$router.replace({name:"qnaModify",params:{articleno:this.article.articleno}})},deleteArticle(){confirm("정말로 글을 삭제하시겠습니까?")&&(0,a.jX)(this.article.articleno,(()=>{this.$router.push({name:"qnaList"})}))},modifyReply(){this.isModifying=!0},cancleReply(){this.isModifying=!1},deleteReply(){confirm("정말로 답글을 삭제하시겠습니까?")&&n.Z["delete"](`/qna/reply/delete/${this.article.articleno}`).then((({data:t})=>{let e="답글 삭제 처리시 문제가 발생했습니다.";"success"===t?(e="답글 삭제가 완료되었습니다.",alert(e),location.reload(!0)):alert(e)}))}}},u=c,d=i(1001),b=(0,d.Z)(u,r,s,!1,null,null,null),p=b.exports},803:function(t,e,i){i.d(e,{fq:function(){return l},jC:function(){return a},jX:function(){return n}});var r=i(6927);const s=(0,r.b)();function a(t,e,i){s.get("/qna",{params:t}).then(e).catch(i)}function l(t,e,i){s.get(`/qna/${t}`).then(e).catch(i)}function n(t,e,i){s.delete(`/qna/${t}`).then(e).catch(i)}}}]);
//# sourceMappingURL=120.acf6d426.js.map