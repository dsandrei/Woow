Ext.define('PM.store.Files', {
    extend: 'Ext.data.Store',
    model: 'PM.model.FileInfo',
    autoLoad: true,

    proxy: {
        type: 'rest',
        api: {
            read: 'rest/files/list',            
        },
        reader: {
            type: 'json',
            root: 'files',
            id: 'id'
        }
    }
});