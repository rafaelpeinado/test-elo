public class TransactionValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(CapturaTransacaoService.class);
    private static final List<String> ALLOWED_BIT_VALUES = List.of("02", "03", "04", "05", "12");

    public void validate(ISOModel m) {
        LOGGER.info("Inicio da validacao");

        boolean isBit02ValueEmpty = m.getBit02() != null && m.getBit02().getValue().isEmpty();
        boolean isBit03Filled = m.getBit03() != null;

        try {
            if (isValid(m, ALLOWED_BIT_VALUES)) {
                if (!isBit02ValueEmpty && ALLOWED_BIT_VALUES.contains("10")) {
                    save(m);
                } else {
                    throw new IllegalArgumentException("Validacao falhou");
                }
            } else {
                throw new IllegalArgumentException("Valores não preenchidos");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu uma exceção durante a validacao: " + e.getMessage());
        }
    }
    
    private void save(ISOModel m) {
        System.out.println("Salvando transacao " + m.getBit02().getValue());
    }

    private boolean isValid(ISOModel m, String... args) {
        for (String arg : args) {
            switch (arg) {
                case "02":
                    if (m.getBit02() == null) {
                        return false;
                    }
                    break;
                case "03":
                    if (m.getBit03() == null) {
                        return false;
                    }
                    break;
                case "04":
                    if (m.getBit04() == null) {
                        return false;
                    }
                    break;
                case "05":
                    if (m.getBit05() == null) {
                        return false;
                    }
                    break;
                case "12":
                    if (m.getBit12() == null) {
                        return false;
                    }
                    break;
                default:
                    LOGGER.warn("Argumento não reconhecido: " + arg);
                    break;
            }
        }
        return true;
    }
}
