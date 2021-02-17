<template>
  <div class="flex flex-row font-S-CoreDream-light font-color-black-400 w-full">
    <section>
      <img
        id="profileImage"
        alt="profile image"
        :src="userInfo[0].img_path"
        class="h-24 w-24 mx-auto mb-3 cursor-pointer rounded-full border-2 border-black object-cover text-center"
      />
    </section>
    <section class="flex flex-col">
      <article class="flex flex-row items-end">
        <span class="text-2xl font-bold">{{ userInfo[0].user_name }}</span>
        <span>님의 프로필</span>
        <div v-if="userInfo[0].user_name !== owner_check">
          <base-button v-if="isFollow" class="text-xs px-2 py-1 ml-2" mode="colored" @click="follow"
            >팔로잉</base-button
          >
          <base-button v-else class="text-xs px-2 py-1 ml-2" mode="outline-colored" @click="follow"
            >팔로우</base-button
          >
        </div>
      </article>
      <article class="flex flex-row">
        <p>작성글 {{ recipeCnt + postCnt }}</p>
        <p class="cursor-pointer" @click="showDialog()">팔로워 {{ followCnt }}</p>
        <p class="cursor-pointer" @click="showDialog()">팔로우 {{ followingCnt }}</p>

        <base-modal
          @close="hideDialog"
          :open="dialogIsVisible"
          class="flex flex-col justify-items-center z-40"
        >
          <section class="modal-header">
            <span>팔로워</span>
          </section>
          <section>
            <section v-if="followList.length > 0" class="mx-1 my-1 py-2 bg-white card rounded-lg">
              <article
                v-for="user in followList"
                :key="user.pk_user"
                class="flex items-center mx-6 my-2"
              >
                <img
                  alt="profile image"
                  :src="tempImage"
                  class="w-12 h-12 mr-4 object-cover rounded-full border-2 border-black"
                />
                <span class="mr-2 font-S-CoreDream-medium">{{ user.user_name }}</span>
                <base-button mode="outline" class="text-xs px-1 py-1 ml-auto justify-self-end"
                  >우짜지</base-button
                >
              </article>
            </section>
            <span
              v-else
              class="text-xl text-center my-32 font-S-CoreDream-medium font-color-black-200"
              >팔로잉하는 유저가 없습니다.</span
            >
          </section>
        </base-modal>
      </article>
    </section>
  </div>
</template>

<script>
export default {
  data() {
    return {
      owner_check: localStorage.getItem('user_name'),
      isFollow: false,
      dialogIsVisible: false,
      isFollower: false,
    };
  },
  computed: {
    userInfo() {
      return this.$store.getters['users/otherMyPage'];
    },
    set_isFollow() {
      return this.$store.getters['follows/isFollow'];
    },
    followList() {
      return this.$store.getters['follows/followList'];
    },
    followingList() {
      return this.$store.getters['follows/followingList'];
    },
    followCnt() {
      return this.$store.getters['follows/followList'].length;
    },
    followingCnt() {
      return this.$store.getters['follows/followingList'].length;
    },
    postCnt() {
      return this.$store.getters['users/myForum'].length;
    },
    recipeCnt() {
      return this.$store.getters['users/myRecipe'].length;
    },
    tempImage() {
      return localStorage.getItem('profileImage');
    },
  },
  created() {
    this.loadUserInfo();
    this.LoadFollowingList();
    this.LoadFollowList();
  },
  updated() {
    this.is_Follow();
    this.isFollow = this.$store.getters['follows/isFollow'];
  },
  methods: {
    async loadUserInfo() {
      const userInfo = {
        mode: 'myPage',
      };
      await this.$store.dispatch('users/LoadOtherMyPage', userInfo);
    },
    async is_Follow() {
      const userInfo = {
        target_no: localStorage.getItem('pkOther'),
      };
      await this.$store.dispatch('follows/isFollow', userInfo);
    },
    async follow() {
      if (localStorage.getItem('user_name') === null) {
        alert('로그인이 필요한 기능입니다.');
        return;
      }
      const mode = this.isFollow ? 'following' : 'x';
      const flag = 1;
      const userInfo = {
        target_no: localStorage.getItem('pkOther'),
        mode: mode,
        flag: flag,
      };
      if (this.isFollow) {
        await this.$store.dispatch('follows/unfollow', userInfo);
      } else {
        await this.$store.dispatch('follows/follow', userInfo);
      }
    },
    async LoadFollowList() {
      const userInfo = {
        target_no: localStorage.getItem('pkOther'),
        mode: 'otherUser',
      };
      await this.$store.dispatch('follows/followList', userInfo);
    },
    async LoadFollowingList() {
      const userInfo = {
        target_no: localStorage.getItem('pkOther'),
        mode: 'otherUser',
      };
      await this.$store.dispatch('follows/followingList', userInfo);
    },

    showDialog() {
      this.dialogIsVisible = true;
    },
    hideDialog() {
      this.dialogIsVisible = false;
    },
  },
  watch: {
    set_isFollow(newVal) {
      this.isFollow = newVal;
    },
  },
};
</script>

<style scoped>
.modal-header {
  margin: 1rem auto;
  display: flex;
  align-items: center;
  font-weight: 700;
  font-size: 18pt;
}
</style>
