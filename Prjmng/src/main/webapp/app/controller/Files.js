Ext.define('PM.controller.Files', {
    extend: 'Ext.app.Controller',

    stores: [
        'Files'
    ],
    
    models: ['FileInfo'],
    
    views: [
        'file.List'
    ],
    

    init: function() {
    	this.control({
            'filelist': {
                itemdblclick: this.downloadFile,
            }
        });
    	
    },
    
    downloadFile: function(grid, record) {
    	console.log("rest/files/get/"+encodeURIComponent(record.data.fileName));
    	window.open("rest/files/get/"+encodeURIComponent(record.data.fileName));
    }
});