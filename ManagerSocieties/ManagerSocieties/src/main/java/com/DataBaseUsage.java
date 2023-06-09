package com;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class DataBaseUsage {

    @PostConstruct
    public void initDataBase () throws IOException {}
}
