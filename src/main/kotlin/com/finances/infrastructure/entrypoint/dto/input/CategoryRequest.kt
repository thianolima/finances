package com.finances.infrastructure.entrypoint.dto.input

import javax.validation.constraints.NotBlank

data class CategoryRequest(@field:NotBlank val name: String)