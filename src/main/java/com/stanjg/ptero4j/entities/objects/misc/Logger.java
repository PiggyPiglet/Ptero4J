package com.stanjg.ptero4j.entities.objects.misc;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
public abstract class Logger {
    public abstract void info(String str);

    public abstract void warning(String str);

    public abstract void error(String str);
}
