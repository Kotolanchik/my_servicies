package ru.kolodkin.catalog.controller;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PRIVATE;

@RestController
@FieldDefaults(level = PRIVATE)
@RequiredArgsConstructor
public class CategoryController {
}
