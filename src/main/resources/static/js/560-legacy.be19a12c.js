"use strict";(self["webpackChunkvue_board_bootstrap"]=self["webpackChunkvue_board_bootstrap"]||[]).push([[560],{31560:function(t,e,n){n.r(e),n.d(e,{default:function(){return k}});var r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("b-container",{staticClass:"bv-example-row mt-3"},[n("b-row",{staticClass:"mb-1"},[n("b-col",{staticClass:"text-right"},[t.isAdmin?n("b-button",{attrs:{variant:"outline-primary"},on:{click:function(e){return t.moveWrite()}}},[t._v("글쓰기")]):t._e()],1)],1),n("b-row",[t.articles.length?n("b-col",[n("b-table-simple",{attrs:{hover:"",responsive:""}},[n("b-thead",{attrs:{"head-variant":"dark"}},[n("b-tr",[n("b-th",[t._v("글번호")]),n("b-th",[t._v("제목")]),n("b-th",[t._v("작성자")]),n("b-th",[t._v("작성일")])],1)],1),n("tbody",t._l(t.articles,(function(e){return n("notice-list-item",t._b({key:e.articleno},"notice-list-item",e,!1))})),1)],1),n("div",{staticClass:"pgn"},[n("b-pagination",{staticClass:"mt-4",attrs:{"total-rows":t.articles.length,"per-page":10},model:{value:t.currentPage,callback:function(e){t.currentPage=e},expression:"currentPage"}})],1)],1):n("b-col",{staticClass:"text-center"},[n("hr"),t._v(" 작성된 공지사항이 없습니다.")])],1)],1)},i=[],c=n(4367),a=n(92317),o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("b-tr",[n("b-td",[t._v(t._s(t.articleno))]),n("b-th",{staticClass:"text-center"},[n("router-link",{attrs:{to:{name:"noticeDetail",params:{articleno:t.articleno}}}},[t._v(t._s(t.subject))])],1),n("b-td",[t._v(t._s(t.userid))]),n("b-td",[t._v(t._s(t._f("dateFormat")(t.regtime)))])],1)},s=[],u=(n(9653),n(17133)),l=n.n(u),b={name:"NoticeListItem",props:{articleno:Number,userid:String,subject:String,hit:Number,regtime:String},filters:{dateFormat:function(t){return l()(new Date(t)).format("YY.MM.DD")}}},f=b,m=n(1001),h=(0,m.Z)(f,o,s,!1,null,null,null),d=h.exports,p=n(34665),v="memberStore",_={name:"NoticeList",components:{NoticeListItem:d},data:function(){return{articles:[],isAdmin:!1,currentPage:1}},created:function(){var t=this,e={pg:1,spp:20,key:null,word:null};(0,a.jC)(e,(function(e){t.articles=e.data}),(function(t){console.log(t)})),"admin"===this.userInfo.userid&&(this.isAdmin=!0)},computed:(0,c.Z)({},(0,p.rn)(v,["userInfo"])),methods:{moveWrite:function(){this.$router.push({name:"noticeRegister"})}}},g=_,C=(0,m.Z)(g,r,i,!1,null,null,null),k=C.exports},92317:function(t,e,n){n.d(e,{cn:function(){return s},fq:function(){return o},hY:function(){return a},jC:function(){return c},jX:function(){return u}});n(38862);var r=n(86927),i=(0,r.b)();function c(t,e,n){i.get("/notice",{params:t}).then(e).catch(n)}function a(t,e,n){i.post("/notice",JSON.stringify(t)).then(e).catch(n)}function o(t,e,n){i.get("/notice/".concat(t)).then(e).catch(n)}function s(t,e,n){i.put("/notice/".concat(t.articleno),JSON.stringify(t)).then(e).catch(n)}function u(t,e,n){i.delete("/notice/".concat(t)).then(e).catch(n)}}}]);
//# sourceMappingURL=560-legacy.be19a12c.js.map