<template>
  <div class="card box-290 flex flex-col">
    <ul class="m-auto">
      <li class="li-margin">
        <router-link to="/header/editprofile">프로필 / 개인정보 수정</router-link>
      </li>
      <li class="li-margin">
        <router-link to="/header/bookmarkedrecipe">북마크한 레시피</router-link>
      </li>
      <li class="li-margin">
        <router-link to="/header/myposts">내가 쓴 글</router-link>
      </li>
      <li class="li-margin">
        <router-link to="/header/activitylog">활동 기록</router-link>
      </li>
      <li class="li-margin">
        <router-link to="/header/followingfollowers">팔로잉 / 팔로워</router-link>
      </li>
    </ul>
    <ul>
      <li class="mb-5 text-center">
        <router-link to="/header/withdraw">탈퇴하기</router-link>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  methods: {},
};
</script>

<style scoped>
.box-290 {
  width: 290px;
  height: 450px;
  background-color: rgb(86, 230, 165);
  border-radius: 30px;
  margin-left: 80px;
}
.li-margin {
  margin: 30px;
}
</style>
