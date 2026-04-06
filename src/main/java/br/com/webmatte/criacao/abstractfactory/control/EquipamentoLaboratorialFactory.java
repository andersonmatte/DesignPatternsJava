package br.com.webmatte.criacao.abstractfactory.control;

import br.com.webmatte.criacao.abstractfactory.interfaces.EquipamentoLaboratorial;

/**
 * @author Anderson Matte
 */
public class EquipamentoLaboratorialFactory {

    public static EquipamentoLaboratorialFactory getFactory(String tipo) {
        switch (tipo.toLowerCase()) {
            case "genetica":
                return new GeneticaFactory();
            case "bioquimica":
                return new BioquimicaFactory();
            case "molecular":
                return new MolecularFactory();
            default:
                throw new IllegalArgumentException("Tipo de laboratório inválido: " + tipo);
        }
    }

    public EquipamentoLaboratorial criarCentrifuga() {
        throw new UnsupportedOperationException("Método não implementado");
    }

    public EquipamentoLaboratorial criarMicroscopio() {
        throw new UnsupportedOperationException("Método não implementado");
    }

    public EquipamentoLaboratorial criarEspectrofotometro() {
        throw new UnsupportedOperationException("Método não implementado");
    }

    private static class GeneticaFactory extends EquipamentoLaboratorialFactory {
        @Override
        public EquipamentoLaboratorial criarCentrifuga() {
            return new EquipamentoLaboratorial() {
                @Override
                public String toString() {
                    return "CentrifugaGenetica";
                }
            };
        }

        @Override
        public EquipamentoLaboratorial criarMicroscopio() {
            return new EquipamentoLaboratorial() {
                @Override
                public String toString() {
                    return "MicroscopioGenetica";
                }
            };
        }

        @Override
        public EquipamentoLaboratorial criarEspectrofotometro() {
            return new EquipamentoLaboratorial() {
                @Override
                public String toString() {
                    return "EspectrofotometroGenetica";
                }
            };
        }
    }

    private static class BioquimicaFactory extends EquipamentoLaboratorialFactory {
        @Override
        public EquipamentoLaboratorial criarCentrifuga() {
            return new EquipamentoLaboratorial() {
                @Override
                public String toString() {
                    return "CentrifugaBioquimica";
                }
            };
        }

        @Override
        public EquipamentoLaboratorial criarMicroscopio() {
            return new EquipamentoLaboratorial() {
                @Override
                public String toString() {
                    return "MicroscopioBioquimica";
                }
            };
        }

        @Override
        public EquipamentoLaboratorial criarEspectrofotometro() {
            return new EquipamentoLaboratorial() {
                @Override
                public String toString() {
                    return "EspectrofotometroBioquimica";
                }
            };
        }
    }

    private static class MolecularFactory extends EquipamentoLaboratorialFactory {
        @Override
        public EquipamentoLaboratorial criarCentrifuga() {
            return new EquipamentoLaboratorial() {
                @Override
                public String toString() {
                    return "CentrifugaMolecular";
                }
            };
        }

        @Override
        public EquipamentoLaboratorial criarMicroscopio() {
            return new EquipamentoLaboratorial() {
                @Override
                public String toString() {
                    return "MicroscopioMolecular";
                }
            };
        }

        @Override
        public EquipamentoLaboratorial criarEspectrofotometro() {
            return new EquipamentoLaboratorial() {
                @Override
                public String toString() {
                    return "EspectrofotometroMolecular";
                }
            };
        }
    }
}
