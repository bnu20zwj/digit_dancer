import $ from 'jquery';

export default {
    state: {
        id:"",
        name:"",
        photo:"",
        token:"",
        is_login: false,
    },
    getters: {
    },
    mutations: {
        updateUser(state,user){
            state.id = user.id;
            state.name = user.name;
            state.photo = user.photo;
            state.is_login = user.is_login;
        },
        updateToken(state,token){
            state.token = token;
        },
    },
    actions: {
        login(context, data){
            $.ajax({
                url:"http://127.0.0.1:3000/user/account/token/",
                type:"post",
                data: {
                name: data.name,
                password: data.password,
                },
                success(resp){
                    if (resp.error_message === "success"){
                        context.commit("updateToken",resp.token);
                        data.success(resp);
                    }else{
                        data.error(resp);
                    }
                    console.log(resp);
                },
                error(resp){
                    data.error(resp);
                    console.log(resp);
                }
            });
        },

        getInfo(context,data){
            $.ajax({
                url:"http://127.0.0.1:3000/user/account/info/",
                type:"get",
                headers: {
                    Authorization:"Bearer "+ context.state.token,
                },
                success(resp){
                    context.commit("updateUser",{
                        ...resp,
                        is_login:true,
                    });
                    data.success(resp);
                },
                error(resp){
                    data.error(resp);
                }
            })
        }
    },
    modules: {
    }
  }