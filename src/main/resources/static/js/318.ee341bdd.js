"use strict";(self["webpackChunkvue_board_bootstrap"]=self["webpackChunkvue_board_bootstrap"]||[]).push([[318],{318:function(t,e,s){s.r(e),s.d(e,{default:function(){return m}});var r=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("b-container",{staticClass:"bv-example-row mt-3"},[s("b-row",[s("b-col",[s("b-alert",{attrs:{variant:"secondary",show:""}},[s("h3",[t._v("회원삭제")])])],1)],1),s("b-row",[t._v(" 정말 삭제하시겠습니까? 이 선택은 되돌릴 수 없습니다! ")]),s("b-row",[s("b-card",{staticClass:"text-center mt-3",staticStyle:{"max-width":"40rem"},attrs:{align:"left"}},[s("b-button",{staticClass:"m-1",attrs:{type:"button",variant:"primary"},on:{click:t.goDelete}},[t._v("삭제하기")]),s("b-button",{staticClass:"m-1",attrs:{type:"button",variant:"success"},on:{click:t.goInfo}},[t._v("돌아가기")])],1)],1)],1)},a=[],o=s(5748),n=s(4665);const u="memberStore";var l={name:"MemberDelete",computed:{...(0,n.rn)(u,["userInfo"])},methods:{...(0,n.OI)(u,["SET_IS_LOGIN","SET_USER_INFO"]),async goDelete(){await o.Z.post("/user/delete",this.userInfo.userid),alert("삭제가 완료되었습니다."),this.SET_IS_LOGIN(!1),this.SET_USER_INFO(null),sessionStorage.removeItem("access-token"),"/"!=this.$route.path&&this.$router.push({name:"home"})},goInfo(){this.$router.push({name:"mypage"})}}},c=l,i=s(1001),b=(0,i.Z)(c,r,a,!1,null,null,null),m=b.exports}}]);
//# sourceMappingURL=318.ee341bdd.js.map