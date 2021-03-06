package br.edu.unibratec.psc.dbdemo.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.unibratec.psc.dbdemo.produto.Produto;
import br.edu.unibratec.psc.dbdemo.produto.ProdutoRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/produto") // This means URL's start with /demo (after Application path)
public class ProdutoController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private ProdutoRepository produtoRepository;

	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewProduto (@RequestParam Integer id
			, @RequestParam String nome , Double preco) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Produto p = new Produto();
		p.setId(id);
		p.setNome(nome);
		p.setPreco(preco);
		produtoRepository.save(p);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Produto> getAllUsers() {
		// This returns a JSON or XML with the users
		return produtoRepository.findAll();
	}
}