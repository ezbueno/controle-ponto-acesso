package com.buenoezandro.acesso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buenoezandro.acesso.dto.JornadaTrabalhoDTO;
import com.buenoezandro.acesso.model.JornadaTrabalho;
import com.buenoezandro.acesso.repository.JornadaTrabalhoRepository;
import com.buenoezandro.acesso.service.exception.ObjetoNaoEncontradoException;
import com.buenoezandro.acesso.util.MensagemUtils;

@Service
public class JornadaTrabalhoService {

	private JornadaTrabalhoRepository jornadaTrabalhoRepository;

	@Autowired
	public JornadaTrabalhoService(JornadaTrabalhoRepository jornadaTrabalhoRepository) {
		this.jornadaTrabalhoRepository = jornadaTrabalhoRepository;
	}

	@Transactional(readOnly = true)
	public List<JornadaTrabalho> buscarTodos() {
		return this.jornadaTrabalhoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public JornadaTrabalho buscarPorId(Long id) {
		return this.jornadaTrabalhoRepository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException(
				MensagemUtils.OBJETO_NAO_ENCONTRADO + id + ", Tipo: " + JornadaTrabalho.class.getName()));
	}

	@Transactional
	public JornadaTrabalho salvar(JornadaTrabalhoDTO jornadaTrabalhoDTO) {
		return this.jornadaTrabalhoRepository.save(new JornadaTrabalho(null, jornadaTrabalhoDTO.getDescricao()));
	}

	@Transactional
	public JornadaTrabalho atualizar(Long id, JornadaTrabalhoDTO jornadaTrabalhoDTO) {
		var jornadaTrabalho = this.buscarPorId(id);
		jornadaTrabalho.setDescricao(jornadaTrabalhoDTO.getDescricao());

		return this.jornadaTrabalhoRepository
				.save(new JornadaTrabalho(jornadaTrabalho.getId(), jornadaTrabalhoDTO.getDescricao()));
	}

	@Transactional
	public void deletar(Long id) {
		var jornadaTrabalho = this.buscarPorId(id);
		this.jornadaTrabalhoRepository.deleteById(jornadaTrabalho.getId());
	}

}
