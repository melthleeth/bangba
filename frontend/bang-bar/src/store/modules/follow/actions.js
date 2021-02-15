const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
    async isFollow(context, payload) {
        const userInfo = {
            user_no : context.rootGetters.pkUser,
            target_no : payload.target_no
        };
        const response = await fetch(`${SERVER_URL}/user/isfollow`, {
            headers: {
                "Content-Type": "application/json; charset=utf-8",
                'Accept': '*/*',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Headers': '*',
            },
            method: "POST",
            body: JSON.stringify(userInfo)
        });
        const responseData = await response.text();
        // console.log(userInfo);
        if(parseInt(responseData) == 1) {
            context.commit("setIsFollow", true);
        } else if(parseInt(responseData) == 0) {
            context.commit("setIsFollow", false);
        } else {
            alert("팔로우 호출이 잘못되었습니다.");
        }
    },
    async follow(context, payload) {
        const userInfo = {
            user_no : context.rootGetters.pkUser,
            target_no : payload.target_no
        };
        const response =await fetch(`${SERVER_URL}/user/follow`,{
            headers: {
                "Content-Type": "application/json; charset=utf-8",
                'Accept': '*/*',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Headers': '*',
            },
            method: "POST",
            body: JSON.stringify(userInfo)
        });
        const responseData = await response.text();

        if(responseData == "SUCCESS") {
            context.commit("setIsFollow", true);
        } else {
            alert("팔로우 실패");
        }
    },
  //   async unfollow(context, payload) {
  //       const userInfo = {
  //           user_no : context.rootGetters.pkUser,
  //           target_no : payload.target_no
  //       };
  //       const response =await fetch(`${SERVER_URL}/user/unfollow`,{
  //           headers: {
  //               "Content-Type": "application/json; charset=utf-8",
  //               'Accept': '*/*',
  //               'Access-Control-Allow-Origin': '*',
  //               'Access-Control-Allow-Headers': '*',
  //           },
  //           method: "POST",
  //           body: JSON.stringify(userInfo)
  //       });
  //       const responseData = await response.text();

  //   if (responseData === "SUCCESS") {
  //     context.commit("setIsFollow", true);
  //   } else {
  //     alert("팔로우 실패");
  //   }
  // },
  async unfollow(context, payload) {
    let userInfo;
    console.log(payload.mode);
    if (payload.mode === "following") {
      userInfo = {
        user_no: context.rootGetters.pkUser,
        target_no: payload.target_no,
      };
    } else if (payload.mode === "follower") {
      userInfo = {
        user_no: payload.target_no,
        target_no: context.rootGetters.pkUser,
      };
    }
    console.log(userInfo);
    const response = await fetch(`${SERVER_URL}/user/unfollow`, {
      headers: {
        "Content-Type": "application/json; charset=utf-8",
        Accept: "*/*",
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Headers": "*",
      },
      method: "POST",
      body: JSON.stringify(userInfo),
    });
    const responseData = await response.text();

    if (responseData === "SUCCESS") {
      context.commit("setIsFollow", false);
    } else {
      alert("팔로우 실패");
    }

    if (payload.mode === "following") context.commit('deleteFollowing', payload.target_no);
    else if (payload.mode === "follower") context.commit('deleteFollower', payload.target_no);
  },

  async followList(context) {
    const response = await fetch(
      `${SERVER_URL}/user/follow/` + context.rootGetters.pkUser + `/ec`,
      {
        headers: {
          "Content-Type": "application/json; charset=utf-8",
          Accept: "*/*",
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Headers": "*",
        },
        method: "GET",
      }
    );

    const responseData = await response.json();
    const followList = [];
    console.log(responseData);
    for (const key in responseData) {
      const follow = {
        pk_user: responseData[key].pk_user,
        user_name: responseData[key].user_name,
        img_path: responseData[key].img_path,
        follow_cnt: responseData[key].follow_cnt,
      };
      followList.push(follow);
    }
    context.commit("setFollowList", followList);
  },
  async followingList(context) {
    const response = await fetch(
      `${SERVER_URL}/user/follow/` + context.rootGetters.pkUser + `/ic`,
      {
        headers: {
          "Content-Type": "application/json; charset=utf-8",
          Accept: "*/*",
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Headers": "*",
        },
        method: "GET",
      }
    );
    const responseData = await response.json();
    const followingList = [];
    console.log(responseData);
    for (const key in responseData) {
      const following = {
        pk_user: responseData[key].pk_user,
        user_name: responseData[key].user_name,
        img_path: responseData[key].img_path,
        follow_cnt: responseData[key].follow_cnt,
      };
      followingList.push(following);
    }
    context.commit("setFollowingList", followingList);
  },
};
