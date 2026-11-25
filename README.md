# Kia Performance Pages

**Native performance instrumentation for Kia Gen5W infotainment, powered by [HMG-API](https://github.com/Open-HMG/HMG-API).**

> Early development • K5-first • No vehicle support claimed until tested

Inspired by SRT Performance Pages and [LIVI](https://github.com/f-io/LIVI), this project aims to deliver a factory-looking performance dashboard without replacing the factory launcher or requiring phone projection.

## Project goals

| Page | Planned functionality |
| --- | --- |
| Dashboard | Boost gauge, GPS speed, RPM, oil temperature and pressure, coolant and transmission temperatures, AFR, intake temperature, and G-force where supported |
| Timers | Closed-course 0–60, 0–120 and 0–peak-speed timing, GPS-based recording, previous and best runs |
| Drive modes | Read active mode; investigate OEM Comfort, Eco, Smart, Sport and Custom selection and Comfort/Sport steering configuration |
| JB4 | Optional verified BLE telemetry, actual/ECU/target boost, map status and supported stationary map selection |
| Settings | Units, configurable gauges, data-source selection and Kia day/night styling |

## Development roadmap

**Mandatory stage gate:** Every stage after Stage 1 begins by reproducing, resolving and regression-testing outstanding issues from the previous stage. Do not add new functionality until the previous stage is stable and its acceptance criteria have been met. Record evidence and limitations in the release changelog.

| Stage | Scope | Exit criteria |
| --- | --- | --- |
| 1 — Foundation (current) | Minimal HMG-API app, home-screen icon, Hello World activity, packaging | Install, launch, exit, relaunch and uninstall on the K5; no projection regressions |
| 2 — Telemetry discovery | Inspect OEM services, Brake Indicator, diagnostic access, GPS and acceleration signals | Document supported signals, units, sampling rates and missing data |
| 3 — Dashboard | Kia-styled gauges and read-only telemetry providers | Validate readings against independent references; stale/unavailable data is explicit |
| 4 — Track timers | GPS speed, stationary arming, motion start, sustained deceleration stop, run history | Closed-course validation, GPS quality checks and repeatable timing |
| 5 — Drive modes | Read mode and investigate factory-supported configuration interfaces | OEM validation and restrictions preserved; unsupported controls remain disabled |
| 6 — JB4 | Investigate adapter compatibility and verified BLE protocol; read-only telemetry first | Stable connection, validated readings and projection coexistence; map selection only if supported and stationary |
| 7 — Polish | Custom layouts, logging, units, themes and broader compatibility | Regression tests, documented compatibility and clean uninstall |

## Design principles

- Kia Gen5W visual language, lightweight rendering and Android 4.4.2 compatibility.
- Standalone HMG-API app; no CPUL, LIVI or Nemesis runtime dependency beyond HMG-API requirements.
- No permanent factory APK modifications, arbitrary CAN writes or fabricated telemetry.
- Separate OEM, GPS, diagnostic and optional JB4 providers.
- Preserve wireless CarPlay and Android Auto; all vehicle control features must respect OEM restrictions.
- Performance timers are for closed-course use only.

## Compatibility

Initial target: 2022 Kia K5 EX (US), Gen5W_M, firmware DL322 US 260507. **Not yet tested.** Other platforms are unverified.

## Building

Stage 1 uses the official HMG-API Mod SDK and Android API 19. CI validates the mod; local signed builds require persistent author and APK signing keys. See `build.sh` once the scaffold is in place.

## Acknowledgments

HMG-API, LIVI and the wider Gen5W modding community. Independent project; not affiliated with Kia, Stellantis or Burger Motorsports.
