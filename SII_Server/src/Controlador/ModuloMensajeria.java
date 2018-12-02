package Controlador;

import java.util.ArrayList;
import java.util.List;

import DAO.ChatDao;
import DAO.UsuarioDao;
import DTO.ChatDTO;
import DTO.UsuarioDTO;
import Entities.ChatEntity;

public class ModuloMensajeria {
	private static ModuloMensajeria controlador;

	public static ModuloMensajeria getInstancia() {
		if (controlador == null) {
			controlador = new ModuloMensajeria();
		}
		return controlador;
	}

	public List<ChatDTO> buscarConversaciones(UsuarioDTO usuario) {
		List<ChatEntity> chats = UsuarioDao.getInstancia().getById(usuario.getIdUsuario()).getChats();
		List<ChatDTO> chatsDto = new ArrayList<ChatDTO>();
		for (ChatEntity c : chats) {
			chatsDto.add(ChatDao.getInstancia().entityToDto(c));
		}
		
		return chatsDto;
	}

}
