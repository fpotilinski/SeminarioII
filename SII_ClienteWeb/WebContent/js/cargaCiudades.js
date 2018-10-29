// Definición de un par de variables
var dataList = document.querySelector('#json-paises'),
		input = document.querySelector('#paises');
// Creamos un nuevo XMLHttpRequest
var request = new XMLHttpRequest();
// Una ves listo, definimos eventos para sus estados
request.onreadystatechange = function(response) {
  if (request.readyState === 4) {
    if (request.status === 200) {
      // Parseando JSON
      var jsonOptions = JSON.parse(request.responseText);
      // Iterando sobre el arreglo JSON
      jsonOptions.forEach(function(item) {
        // Creando un option por cada país.
        var option = document.createElement('option');
        option.value = item;
        dataList.appendChild(option);
      });
      input.placeholder = "Escribe el nombre de un país";
    } else {
      // Error!
      input.placeholder = "Error al cargar lista de países ;^(";
    }
  }
};
// Cambiamos el texto del placeholder
input.placeholder = "Cargando países";
// Abrimos y enviamos el request
request.open('GET', '/SII_ClienteWeb/json-paises.json', true);
request.send();
