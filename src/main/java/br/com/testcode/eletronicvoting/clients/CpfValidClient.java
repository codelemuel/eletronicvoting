package br.com.testcode.eletronicvoting.clients;

import br.com.testcode.eletronicvoting.models.dtos.CpfValidDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cpf-valid-client", url = "${validator-cpf-client}")
public interface CpfValidClient {

	@GetMapping(path = "/{cpf}")
	CpfValidDTO getStatusCpf(@PathVariable Long cpf);

}
