package it.plansoft.demojpa.controller;/* ggrosso created on 21/02/2021 inside the package - it.plansoft.demojpa.controller */

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import it.plansoft.demojpa.controller.interfaces.ICrudController;
import it.plansoft.demojpa.service.BaseCrudService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.transaction.Transactional;

@NoArgsConstructor
public class BaseCrudController<SERVICE extends BaseCrudService<REPOSITORY, MODEL, ID>, REPOSITORY extends JpaRepository<MODEL, ID>, MODEL, ID>
		implements ICrudController<MODEL, ID> {

	protected SERVICE service;

	public BaseCrudController(SERVICE service) {
		this.service = service;
	}

	// ?page=0&size=2&sort=createdAt,desc
	@GetMapping("/paged")
	public ResponseEntity<Page<MODEL>> findAll(Pageable pageable) {
		Page<MODEL> page = service.findAll(pageable);
		return ResponseEntity.ok(page);
	}

    @GetMapping("/")
    public ResponseEntity<List<MODEL>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Optional<MODEL>> findById(@PathVariable ID id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@Override
	@PostMapping("/")
	public ResponseEntity<MODEL> save(@RequestBody MODEL model) {
		return ResponseEntity.ok(service.save(model));
	}

	@Override
	@PostMapping("/addAll")
	public ResponseEntity<List<MODEL>> saveAll(@RequestBody List<MODEL> model) {
		List<MODEL> mout = new ArrayList<>();
		for (MODEL m: model) {
			mout.add(m);
			service.save(m);
		}
		return ResponseEntity.ok(mout);
	}

	@Override
	@DeleteMapping("/")
	public void delete(@RequestBody MODEL model) {
		service.delete(model);
	}

	@Override
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable ID id) {
		service.deleteById(id);
	}

	@Override
	@PutMapping("/")
	public ResponseEntity<MODEL> update(@RequestBody MODEL model) {
		return ResponseEntity.ok(service.save(model));
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<MODEL> update(@PathVariable ID id, @RequestBody MODEL model) {
		return ResponseEntity.ok(service.save(model));
	}
}
