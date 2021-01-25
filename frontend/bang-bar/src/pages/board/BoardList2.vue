<template>
  <div style="text-align:center">
    <h1>게시판</h1>
    <h5>공지사항, 후기, 질문</h5>

		<div class="container" style="text-align:center">
      <div>
      <base-button class=redbutton>글쓰기</base-button>
      
      <select id="year" name="year">
                  <option value="전체">전체</option>
                  <option value="공지사항">공지사항</option>
                  <option value="후기">후기</option>
                  <option value="질문">질문</option>
                  
      </select>
			<input type="nickname" id="nickname" v-model="nickname" class="textarea"/><base-button>검색</base-button>
      </div>
			<div class = "row">
				<table class = "table-striped" style="text-align:center ; border:1px solid #dddddd">
					<thead>
						<tr>
							<th style = "background-color:#eeeeee; text-align:center;">번호</th>
							<th style = "background-color:#eeeeee; text-align:center;">제목</th>
							<th style = "background-color:#eeeeee; text-align:center;">작성자</th>
							<th style = "background-color:#eeeeee; text-align:center;">작성일</th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<td>1</td>
						<td>안녕하세요.</td>
						<td>홍길동</td>
						<td>2020-06-17</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
  </div>
</template>


<script>
export default {
  
}
</script>


<style scoped>
p {
  margin: 0;
  font-family: Noto Sans KR;
  font-style: normal;
  font-weight: bold;
  font-size: 64px;
  line-height: 93px;
  display: flex;
  align-items: center;

  color: #23232f;
}

.table-striped{
 /* color: red; */
}

</style>
