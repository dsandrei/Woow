Ext.onReady(function(){
    var login = Ext.create('Ext.form.Panel', {
        labelWidth:80,
        url:'j_spring_security_check',
        frame:true,
        title:'Please Login',
        defaultType:'textfield',
        width:300,
        height:150,
        monitorValid:true,
        items:[{
            fieldLabel:'Username',
            name:'j_username',
            allowBlank:false
        },{
            fieldLabel:'Password',

            name:'j_password',
            inputType:'password',
            allowBlank:false
        }],

        buttons:[{

            text:'Login',
            formBind: true,
            handler:function(){
            login.getForm().submit({

                method:'POST',
                success:function(){
                Ext.Msg.alert('Status', 'Login Successful!', function(btn, text){

                    if (btn == 'ok'){
                        window.location = 'index.html';
                    }
                });

            },

            failure:function(form, action){
                Ext.Msg.alert('Login Failed!', 'The credentials you provided are not correct');  
                login.getForm().reset();
            }
            });
        }
        }]
    });
    login.render('login');
});