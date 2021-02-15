<template>
  <div class="flex flex-row">
    <section>
      <img
        id="profileImage"
        alt="profile image"
        :src="img_path"
        class="h-24 w-24 mx-auto mb-3 cursor-pointer rounded-full border-2 border-black object-cover text-center"
      />
    </section>
    <section class="flex flex-col">
      <article class="flex flex-row">
        <span class="text-lg">{{ pk_name }}</span>
        <span>님의 프로필</span>
        <base-button>팔로우</base-button>
      </article>
      <ul class="flex felx-row">
        <li>작성글 {{}}</li>
        <li>팔로워 {{ followCnt }}</li>
        <li>팔로우 {{ followingCnt }}</li>
      </ul>
    </section>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pk_user: 1,
      pk_name: '피곤한 부엉이',
      img_path:
        'https://w7.pngwing.com/pngs/53/330/png-transparent-emoji-frown-android-email-google-frowning-smiley-emoticon-sms-thumbnail.png',
      imgsrc: require('../../assets/img/profile2.png'),
    };
  },
  computed: {
    userInfo() {
      return this.$store.getters['users/otherMyPage'];
    },
    followList() {
      return this.$store.getters['follows/followList'];
    },
    followingList() {
      return this.$store.getters['follows/followingList'];
    },
    followCnt() {
      return this.followList.length;
    },
    followingCnt() {
      return this.followingList.length;
    },
  },
  created() {
    this.loadUserInfo();
    this.LoadFollowingList();
    this.LoadFollowList();
  },
  methods: {
    async loadUserInfo() {
      await this.$store.dispatch('users/LoadOtherMyPage');
    },
    async LoadFollowList() {
      await this.$store.dispatch('follows/followList');
    },
    async LoadFollowingList() {
      await this.$store.dispatch('follows/followingList');
    },
  },
};
</script>

<style scoped></style>
