Ext.application({
    requires: ['Ext.panel.Panel','PM.controller.Files'],    
    name: 'PM',

    appFolder: 'app',
    
    controllers: ['Files'],

    launch: function() {
        Ext.create('Ext.panel.Panel', {
            layout: 'fit',
            width:500,
            height:500,
            border:0,
            renderTo:'content',
            id : 'mainViewPort',
            items: [{
                xtype: 'filelist'  
            }]
        });
    }
});