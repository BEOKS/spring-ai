/*
 * Copyright 2023-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.ai.chat.messages;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Unit tests for {@link MessageUtils}.
 *
 * @author Thomas Vitale
 */
class MessageUtilsTests {

	@Test
	void readResource() {
		String content = MessageUtils.readResource(new ClassPathResource("prompt-user.txt"));
		assertThat(content).isEqualTo("Hello, world!");
	}

	@Test
	void readResourceWhenNull() {
		assertThatThrownBy(() -> MessageUtils.readResource(null)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("resource cannot be null");
	}

	@Test
	void readResourceWithCharset() {
		String content = MessageUtils.readResource(new ClassPathResource("prompt-user.txt"), StandardCharsets.UTF_8);
		assertThat(content).isEqualTo("Hello, world!");
	}

	@Test
	void readResourceWithCharsetWhenNull() {
		assertThatThrownBy(() -> MessageUtils.readResource(new ClassPathResource("prompt-user.txt"), null))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("charset cannot be null");
	}

}
