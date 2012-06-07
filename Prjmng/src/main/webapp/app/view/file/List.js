Ext.define('PM.view.file.List', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.filelist',

	title : 'Available files',

	store : 'Files',
	
	width: 500,	
	height: 500,
	frame:true,
	
	columns : [ {
		header : 'File name',
		dataIndex : 'fileName',
		flex : 1
	},
	{
		header : 'File size',
		dataIndex : 'fileSize',
		flex : 1
	}	
	],	    
    
	constructor : function(config) {		
		this.callParent(arguments);
	},
	
	initComponent : function() {
		this.callParent(arguments);
	}
});