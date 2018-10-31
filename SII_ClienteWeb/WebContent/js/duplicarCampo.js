$(document).ready(function(){
    var next = 1;
    $(".btn-light").click(function(e){
        e.preventDefault();
        var addto = "#ciudad" + next;
        var addRemove = "#ciudad" + (next);
        next = next + 1;
        var newIn = '<input autocomplete="off" class="input form-control" id="ciudad' + next + '" name="ciudad' + next + '" type="text">';
        var newInput = $(newIn);
        var removeBtn = '<button id="remove' + (next - 1) + '" class="btn btn-secondary" >Eliminar anterior</button></div><div id="ciudad">';
        var removeButton = $(removeBtn);
        $(addto).after(newInput);
        $(addRemove).after(removeButton);
        $("#ciudad" + next).attr('data-source',$(addto).attr('data-source'));
        $("#count").val(next);  
        
            $('.btn-secondary').click(function(e){
                e.preventDefault();
                var fieldNum = this.id.charAt(this.id.length-1);
                var fieldID = "#ciudad" + fieldNum;
                $(this).remove();
                $(fieldID).remove();
            });
    });
    

    
});