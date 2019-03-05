$(document).ready(function () {
    loadItems(function (items) {
        items.forEach(showItem)
    })
})


//Carga todos los items del servidor
function loadItems(showItems){
    $.ajax({
        url:'./items'
    }).done(function (items) {
        console.log("Items: "+JSON.stringify(items))
        showItems(items)
    })
}

//Crea un nuevo item
function createItem(item,show){
    $.ajax({
        method:'POST',
        url:'./items',
        data: JSON.stringify(item),
        processData: false,
        headers:{
            'Content-Type':'application/json'
        }
    }).done(function (item) {
        console.log(JSON.stringify(item))
        show(item)
    })
}

//Actualiza un item
function updateItem(item,id) {
    $.ajax({
        method:'PUT',
        url:'./items/'+id,
        data:JSON.stringify(item),
        processData:false,
        headers:{
            'Content-Type':'application/json'
        }
    }).done(function (item){
        console.log(JSON.stringify(item))
    })
}

//Elimina un item
function deleteItem(id){
    $.ajax({
        method:'DELETE',
        url:'./items/'+id
    }).done(function (item) {
        console.log('Item '+id+' eliminado')
    })
}

//
function showItem(item){
    var checked=''
    var style=''
    if(item.checked){
        checked = 'checked'
        style = 'style="text-decoration:line-through"'
    }
    $('#info').append(
        '<p id="item-' + item.id + '"><label><input id="task-'+item.id+'" type="checkbox" ' + checked + '/><span'+ style + '>' + item.description +
        '</span></label><button class="btn waves-effect waves-light">Delete</button></p>')
}

$('#add-button').on('click',function () {
    var input=$('#value-input')
    var item={
        description:input.val(),
        checked:false
    }
    input.val('')
    createItem(item,function (newItem) {
        showItem(newItem)
    })
})

$('#info').on('click',function (event) {
    var element=$(event.target)
    if(element.is('button')){
        var itemDiv=element.parent()
        var itemId=itemDiv.attr('id').split('-')[1]
        itemDiv.remove()
        deleteItem(itemId)
    }
})

$('#info').on('change',function (event){
    var element=$(event.target)
    var itemDiv=element.parent();
    var textLavel=element.find('label')

    var itemDescription=textLavel.text()
    var itemChecked=element.prop('checked')
    var itemId=itemDiv.parent().attr('id').split('-')[1]

    var item={
        id:itemId,
        description:itemDescription,
        checked:itemChecked
    }

    updateItem(item,itemId)

    var style=itemChecked? 'line-through':'none'
    textLavel.css('text-decoration',style)
})



