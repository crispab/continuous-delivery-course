/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.hateoas.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sample.hateoas.domain.About;
import sample.hateoas.domain.Customer;
import sample.hateoas.domain.CustomerRepository;

@Controller
@RequestMapping("/about")
public class AboutController {

	private final EntityLinks entityLinks;

	@Value("${app.version}")
	private String version;

	public AboutController(EntityLinks entityLinks) {
		this.entityLinks = entityLinks;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	HttpEntity<Resource<About>> showVersion() {
		About about = new About(version);
		Resource<About> resource = new Resource<>(about);
		return new ResponseEntity<>(resource, HttpStatus.OK);
	}
}
