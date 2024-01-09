package cat.itacademy.barcelonactiva.lopez.pedro.s05.study.config;

import org.springframework.core.env.PropertySource;

class BootifulPropertySource extends PropertySource<String> {
    BootifulPropertySource() {
        super("bootiful");
    }

    @Override
    public Object getProperty(String name) {
        if (name.equalsIgnoreCase("bootiful-message")) {
            return "Hi from " + BootifulPropertySource.class.getSimpleName();
        }
        return null;
    }
}
