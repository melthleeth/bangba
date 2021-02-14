<template>
  <div class="flex flex-col font-S-CoreDream-light font-color-black-400 w-max">
    <span
      class="tracking-wider font-semibold text-2xl border-gray-800 border-b-4 font-S-CoreDream-medium w-max px-1 mt-10"
      >팔로잉/팔로워</span
    >
    <div class="flex grid grid-cols-3 grid-flow-row gap-4"></div>
    <div>팔로잉 - {{followingCnt}}</div>
    {{followingList}}
    <div>팔로워 - {{followCnt}}</div>
    {{followList}}
  </div>
</template>

<script>
// const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
    data() {
        return {
            followList:[],
            followingList:[],
            followCnt : 0,
            followingCnt : 0,
        }
    }, 
    created() {
      this.LoadFollowingList();
      this.LoadFollowList();
      this.followList = this.$store.getters["follows/followList"];
      this.followingList = this.$store.getters["follows/followingList"];
      console.log(this.$store.getters["follows/followList"]);
      console.log(this.$store.getters["follows/followingList"]);
      for (let i = 0; i < this.followList.length; i++) {
        this.followCnt += this.followList[i].follow_cnt;
      }
      for (let i = 0; i < this.followingList.length; i++) {
        this.followingCnt += this.followingList[i].follow_cnt;
      }

    },
    watch : {
      set_followList(newVal) {
        this.followList = newVal;
      },
      set_followingList(newVal) {
        this.followingList = newVal;
      }
    },
    computed : {
      set_followList() {
        return this.$store.getters["follows/followList"];
      },
      set_followingList() {
        return this.$store.getters["follows/followingList"];
      }
    },
    methods: {
      async LoadFollowList() {
        await this.$store.dispatch("follows/followList");
      },
      async LoadFollowingList() {
        await this.$store.dispatch("follows/followingList");
      }
    }
}
</script>

<style scoped>

</style> 